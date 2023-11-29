import java.io.File;

public class FileExplorer {
   private File currentDirectory;

   public FileExplorer() {
       this.currentDirectory = new File(System.getProperty("user.dir"));
   }

   public void pwd() {
       System.out.println(currentDirectory.getAbsolutePath());
   }

   public void ls() {
       String[] files = currentDirectory.list();
       for (String file : files) {
           System.out.println(file);
       }
   }

   public void cd(String path) {
       File newDirectory = new File(currentDirectory, path);
       if (newDirectory.isDirectory()) {
           currentDirectory = newDirectory;
       } else {
           System.out.println("Não é um diretório");
       }
   }

   public void mkdir(String path) {
       File newDirectory = new File(currentDirectory, path);
       if (newDirectory.mkdir()) {
           System.out.println("Diretório criado");
       } else {
           System.out.println("Não foi possível criar o diretório");
       }
   }

   public void rm(String path) {
       File fileToDelete = new File(currentDirectory, path);
       if (fileToDelete.isDirectory()) {
           if (fileToDelete.delete()) {
               System.out.println("Diretório removido");
           } else {
               System.out.println("Não foi possível remover o diretório");
           }
       } else {
           System.out.println("Não é um diretório");
       }
   }
}

