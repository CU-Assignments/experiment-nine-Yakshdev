import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

public class MainTransferApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TransferService service = context.getBean(TransferService.class);

        try {
            service.transfer(1, 2, 500);
            System.out.println("Transfer successful.");
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }
}
