public class Main {

    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();

        System.out.println("Nome do Aplicativo: " + config.getAppName());
        System.out.println("Versão do Aplicativo: " + config.getAppVersion());
        System.out.println("Descrição do Aplicativo: " + config.getAppDescription());
    }

}