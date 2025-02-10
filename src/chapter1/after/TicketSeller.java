package chapter1.after;


public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
            // TicketSeller가 Audience에 의존하던 코드들을 Audience 내부로 캡슐화
            ticketOffice.sellTicketTo(audience);
    }
}
