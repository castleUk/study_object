package chapter1.after;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    /* Arrays.asList vs List.of
    * asList는 Thread-Safe 하지 않음 vs List.of는 완전 불변
    * asList는 null요소를 허용 vs List.of()는 null 요소를 허용하지 않음
    * List.of가 메모리를 덜 사용하므로 완전 불변인 List.of 사용을 권장
    * asList는 set을 사용할수 있어서, 완전 불변이 아님
    **/


    /* ... varargs(variable argument) - 가변인자
    *  타입 ... 변수명
    *  내부적으로 배열을 생성해서 사용한다
    *  가변인자 외에도 다른 매개변수가 있다면 가변인자는 마지막에 선언해야 한다.
    * */


    private Ticket getTicket() {
        return tickets.remove(0);
    }


    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
