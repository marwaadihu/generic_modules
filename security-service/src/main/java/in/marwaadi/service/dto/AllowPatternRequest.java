package in.marwaadi.service.dto;

import java.util.Arrays;

/**
 * @author anil.agrawal
 *
 */
public class AllowPatternRequest {

	private final String[] patterns;

	public AllowPatternRequest(String[] patterns) {
		super();
		this.patterns = patterns;
	}

	/**
	 * @author anil.agrawal
	 * @return the patterns
	 */
	public String[] getPatterns() {
		return patterns;
	}

	@Override
	public String toString() {
		return "AllowPatternRequest [patterns=" + Arrays.toString(patterns) + "]";
	}

}
