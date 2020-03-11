package services;
import Dao.BookingDao;
import model.Booking;
import model.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private BookingDao bookingDao = new BookingDao();


    public boolean makeBooking(int tickets) {
        return bookingDao.create(bookingDao.makeBooking(tickets));
    }

    public List<Booking> showMyBookings() {
        List<Booking> collect=new ArrayList<>();
        try {
         collect = bookingDao.getAll()
                    .stream()
                    .filter(booking -> booking.getUser()
                            .equals(Session.getUser()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("smthng went wrong");
        }
        return collect;
    }

    public void cancelBooking(int cancelID)  {
        try {
            bookingDao.delete(cancelID);
        } catch (Exception e) {
            System.out.println("smthng went wrong");
        }
    }
}
