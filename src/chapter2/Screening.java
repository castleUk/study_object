package chapter2;

import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	// 상영 시작 시간을 반환
	public LocalDateTime getStartTime() {
		return whenScreened;
	}

	// 순번의 일치 여부를 검사
	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}

	// 기본 요금 반환
	public Money getMovieFee() {
		return movie.getFee();
	}

	// 예매 기능
	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		return movie.caculateMovieFee(this).times(audienceCount);
		// Screening이 Movie에게 calculateMovieFee 메시지를 전송한다.
	}


}
