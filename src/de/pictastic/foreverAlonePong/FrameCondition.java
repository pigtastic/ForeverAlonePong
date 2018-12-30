package de.pictastic.foreverAlonePong;

public class FrameCondition {
	
	private String condition = "";
	
	public FrameCondition () {
	}
	/**
	 * Mögliche Zustände: AFTERGAME , BEFOREGAME
	 * @param condition
	 */
	public void setCondition (String condition) {
		this.condition = condition;
	}
/**
 * 
 * @return condition
 */
	public String getCondition() {
		return condition;
	}
	
	
	
}
