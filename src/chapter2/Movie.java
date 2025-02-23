package chapter2;

import java.time.Duration;

public class Movie {
	private String title;
	private Duration runningTime;
	// Period는 날짜간의 차이를 나타내고
	// Duration은 시간간의 차이를 계산하는 클래스


	private Money fee;
	private DiscountPolicy discountPolicy;

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}

	public Money getFee() {
		return fee;
	}

	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
}
