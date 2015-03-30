package filePath;

public class FilePath {
    
    public String reduceFilePath(String filePath){
        if(filePath.length() == 0){
            return "/";
        }else{
            while(filePath.contains("/./")){
                filePath = filePath.replace("/./", "/");
            }
            int start = 0;
            int end = 0;
            int i = 0;
            
            while(filePath.contains("/..") && i <= filePath.length() - 3) {
                if ((filePath.charAt(i) == '/') &&
                        (filePath.charAt(i+1) == '.') && (filePath.charAt(i+2) == '.')){
                    start = i;
                    for(int j = 3; j<i; j++){
                        if(filePath.charAt(j) == '/'){
                            end = j;
                        }
                    }
                    filePath = filePath.substring(0, end) + filePath.substring(start, filePath.length());
                }
                i++;
            }
            
            if(filePath.length() > 1 && filePath.charAt(filePath.length()-1) == '/'){
                filePath = filePath.substring(0, filePath.length() - 1);
            }
            
            filePath = filePath.replace("..", "");
            filePath = reduceDoubleSlashes(filePath);
        }
        
        
        return filePath;
        
        
    }
    
    public String reduceDoubleSlashes(String filePath){
        while(filePath.contains("//")){
            filePath = filePath.replace("//", "/");
        }
        return filePath;
        
    }
}