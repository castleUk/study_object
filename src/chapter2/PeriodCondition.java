package chapter2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
	private DayOfWeek dayOfWeek; // DayOfWeek은 요일을 처리하기 위한 enum;
	private LocalTime startTime;
	private LocalTime endTime;

	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}



	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) && // screening의 상영 요일이 dayOfWeek 와 같고
				startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 && // 상영 시작 시간이 startTime과 endTime 사이에 있을 경우 True
				endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
	}
}
