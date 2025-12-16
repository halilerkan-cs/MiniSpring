import controller.AccountController;

public class Main {
    public static void main(String[] args) {
        MiniBeanFactory beanFactory = new MiniBeanFactory();
        AccountController accountController = (AccountController) beanFactory.getBean(AccountController.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(accountController.getAccount(String.valueOf(i)));
        }
    }
}