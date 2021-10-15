class FileSystem {
    
    class Directory {
        String name;
        HashMap<String, Directory> childDirectory;
        HashMap<String, File> childFile;
        
        public Directory(String name) {
            this.name = name;
            this.childDirectory = new HashMap<>();
            this.childFile = new HashMap<>();
        }
    }
    
    class File {
        String name;
        StringBuilder content;
        
        public File(String name, String content) {
            this.name = name;
            this.content = new StringBuilder();
            this.content.append(content);
        }
    }

    Directory root;
    public FileSystem() {
        root = new Directory("");
        // a DS that stores directory
        // a class called Directory
            // String name;
            // HashSet<Directory> childDirectory;
            // HashSet<Files> fileDirectory;
        
        // a DS that stores files --> respect their respective position
        
        // a DS that stores content of files
        // a class called File that store a string (StringBuilder) "content";
    }
    
    private Directory cd(String[] pathArr, boolean isFile) {
        Directory curr = root;
        if(pathArr.length == 0) return curr;
        
        for(int i = 0; i < pathArr.length - 1; i++) {
            // if dir does not exist, create dir
            if(pathArr[i].equals("")) continue;
            if(!curr.childDirectory.containsKey(pathArr[i])) {
                curr.childDirectory.put(pathArr[i], new Directory(pathArr[i]));
            }
            curr = curr.childDirectory.get(pathArr[i]);
        }
        
        String finalPath = pathArr[pathArr.length - 1];
        if(isFile) return curr;
        else {
            if(curr.childFile.containsKey(finalPath)) 
                return null; // return file
            else {
                if(!curr.childDirectory.containsKey(finalPath))
                    curr.childDirectory.put(finalPath, new Directory(finalPath));
                curr = curr.childDirectory.get(finalPath);
                return curr;
            }
        }
    }
    
    public List<String> ls(String path) {
        List<String> lsFiles = new ArrayList<>();
        
        String[] pathArr = path.split("/");
        
        Directory curr = cd(pathArr, false);
        if(curr == null) {
            lsFiles.add(pathArr[pathArr.length - 1]);
        } else {
            for(String dir : curr.childDirectory.keySet())
                lsFiles.add(curr.childDirectory.get(dir).name);
            for(String f : curr.childFile.keySet()) 
                lsFiles.add(curr.childFile.get(f).name);
            Collections.sort(lsFiles);
        }
        
        return lsFiles;
    }
    
    public void mkdir(String path) {
        String[] pathArr = path.split("/");
        cd(pathArr, false);
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] pathArr = filePath.split("/");
        String fileName = pathArr[pathArr.length - 1];
        Directory curr = cd(pathArr, true);
        curr.childFile.putIfAbsent(fileName, new File(fileName, ""));
        curr.childFile.get(fileName).content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] pathArr = filePath.split("/");
        String fileName = pathArr[pathArr.length - 1];
        Directory curr = cd(pathArr, true);
        return curr.childFile.get(fileName).content.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */