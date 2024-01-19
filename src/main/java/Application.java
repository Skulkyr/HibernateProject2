import entity.persons.Customer;
import service.FilmStoreService;

public class Application {


    public static void main(String[] args) {

        FilmStoreService service = FilmStoreService.INCTANCE;
        //
        //Customer customer = service.createCustomer();
        //service.customerRentInventory(customer);
        //service.returnFilmToStore();
        service.addNewFilm();


    }

}
