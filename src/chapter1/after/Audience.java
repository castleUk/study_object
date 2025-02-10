package chapter1.after;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}



/*
* Audience는 자신이 가진 소지품을 스스로 관리한다.
* 조금 더 개선해 보자면
* Bag도 자율적인 존재로 만들어 보자.
* */