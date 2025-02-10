package chapter1.before;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) { // 초대장이 있으면
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 티켓 셀러가 티켓오피스에서 티켓을 꺼내서
            audience.getBag().setTicket(ticket); // 관중의 가방안에 티켓을 넣어준다
        } else {  // 초대장이 없으면
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 티켓셀러가 티켓오피스에서 티켓을 꺼낸후
            audience.getBag().minusAmount(ticket.getFee()); // 티켓 가격만큼 관중의 가방에서 돈을 빼고
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee()); // 티켓오피스에 티켓 가격만큼 돈을 더 한후
            audience.getBag().setTicket(ticket); // 관중의 가방안에 티켓을 넣어준다
        }
    }
}


/* 무엇이 문제인가?
* 잘만든 모듈의 세가지 기능
* 1. 제대로 동작한다.
* 2. 변경에 용이해야 한다.
* 3. 이해하기 쉬워야 한다.
*
* chapter1.type1 모듈의 코드들은 제대로 동작한다. 하지만, 변경에 용이하지도 이해하기 쉽지도 않은 코드이다.
* 왜그런가?
* 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재임
* 이해가능한 코드란 그 동작이 우리의 예상에서 크게 벗어나지 않아야 한다. 하지만 해당 코드들은 상식의 예상에서 크게 벗어난다.
* 가장 심각한 문제는 Audience와 TicketSeller를 변경할 경우 Theater도 함게 변경되야 한다는 것이다.
*
* 다른 클래스들이 Audience의 내부에 더 많이 알면 알수록 Audience를 변경하기 어려워 진다.
* 이것이 객체 사이의 의존성 문제이며, 결합도가 높다고 말한다.
*
* ---- 해결해보자-----
* Theater가 Audience와 TicketSeller에 관해 너무 세세한 부분까지 알지 못하도록 차단하면 된다.
* 다시말해 관람객과 판매원을 자율적인 존재로 만들면 되는 것이다.
*  ======> chapter1.type2 모듈로 수정
*
*
* */