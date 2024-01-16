package service;

import dao.*;
import entity.film.*;
import entity.location.Address;
import entity.location.City;
import entity.location.Country;
import entity.location.Language;
import entity.payment.Payment;
import entity.payment.Rental;
import entity.payment.Store;
import entity.persons.Actor;
import entity.persons.Customer;
import entity.persons.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum FilmStoreService {

    INCTANCE;

    private final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Category.class)
            .addAnnotatedClass(Film.class)
            .addAnnotatedClass(FilmText.class)
            .addAnnotatedClass(Inventory.class)
            .addAnnotatedClass(Address.class)
            .addAnnotatedClass(City.class)
            .addAnnotatedClass(Country.class)
            .addAnnotatedClass(Language.class)
            .addAnnotatedClass(Payment.class)
            .addAnnotatedClass(Rental.class)
            .addAnnotatedClass(Store.class)
            .addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Staff.class)
            .buildSessionFactory();

    private final ActorDao actorDao = new ActorDao(sessionFactory);
    private final AddressDao addressDao = new AddressDao(sessionFactory);
    private final CategoryDao categoryDao = new CategoryDao(sessionFactory);
    private final CityDao cityDao = new CityDao(sessionFactory);
    private final CountryDao countryDao = new CountryDao(sessionFactory);
    private final CustomerDao customerDao = new CustomerDao(sessionFactory);
    private final FilmDao filmDao = new FilmDao(sessionFactory);
    private final FilmTextDao filmTextDao = new FilmTextDao(sessionFactory);
    private final InventoryDao inventoryDao = new InventoryDao(sessionFactory);
    private final LanguageDao languageDao = new LanguageDao(sessionFactory);
    private final PaymentDao paymentDao = new PaymentDao(sessionFactory);
    private final RentalDao rentalDao = new RentalDao(sessionFactory);
    private final StaffDao staffDao = new StaffDao(sessionFactory);
    private final StoreDao storeDao = new StoreDao(sessionFactory);


    public Customer createCustomer() {

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Store store = storeDao.getById(1);
            Address address = new Address();
            address.setAddress("Gavna");
            address.setCity(cityDao.getCityByName("Moscow"));
            address.setDistrict("District 12");
            address.setPhone("89601427312");


            addressDao.save(address);

            Customer customer = new Customer();
            customer.setAddress(address);
            customer.setStore(store);
            customer.setActive(true);
            customer.setEmail("gamno@gmail.com");
            customer.setFirstName("Vladimir");
            customer.setLastName("Stalone");

            customerDao.save(customer);

            session.getTransaction().commit();

            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean returnFilmToStore() {
        sessionFactory.getCurrentSession().beginTransaction();
        Rental rental = rentalDao.getAnyUnreturned();

        rental.setReturnDate(LocalDateTime.now());

        rentalDao.save(rental);

        sessionFactory.getCurrentSession().getTransaction().commit();
        System.out.println("Returned film id: " + rental.getId());
        return true;
    }

    public void customerRentInventory(Customer customer) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Film film = filmDao.getFirstAvailableFilmToRent();

            Inventory inventory = new Inventory();
            Store store = storeDao.getById(1);

            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDao.save(inventory);

            Staff staff = store.getManagerStaff();

            Rental rental = new Rental();
            rental.setDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDao.save(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setAmount(BigDecimal.valueOf(55.77));
            payment.setRental(rental);
            payment.setPaymentDate(LocalDateTime.now());
            paymentDao.save(payment);

            session.getTransaction().commit();
        }
    }

    public Film addNewFilm() {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Language language = languageDao.getById(5);
            Set<Actor> actors = new HashSet<>(actorDao.getItems(4, 10));
            Set<Category> categories = new HashSet<>(categoryDao.getItems(1, 5));

            Film film = new Film();
            film.setActors(actors);
            film.setCategories(categories);
            film.setDescription("???");
            film.setFeatures("Trailers");
            film.setRentalDuration((short) 12);
            film.setTitle("My best film");
            film.setOriginalLanguage(language);
            film.setLanguage(language);
            film.setRentalRate(BigDecimal.valueOf(0.00));
            film.setReplacementCost(BigDecimal.valueOf(55.12));
            film.setRating(Rating.NC17);

            filmDao.save(film);

            session.getTransaction().commit();
            return film;
        }
    }

}
