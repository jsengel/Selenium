package fr.jeromesengel.selenium.home;

import org.springframework.stereotype.Service;

import fr.jeromesengel.selenium.common.Result;

@Service
public class HomeServiceImpl implements HomeService {

	private Result result;

	@Override
	public Result fakeBusinessMethod() {
		if (result == null) {
			// The first call of this method will always return a FAIL
			result = Result.FAIL;
		} else {
			switch (result) {
			case FAIL:
				// If the previous result was a fail, then we should try again maybe it will work this time !
				result = Result.PENDING;
				break;
			case PENDING:
				// If the previous result was pending, we assume it's a success now
				result = Result.SUCCESS;
				break;
			case SUCCESS:
				// If the previous result was a success, let's start over the cycle with a FAIL !
			default:
				// Unknown result ? I think this is a clear FAIL too !
				result = Result.FAIL;
				break;
			}
		}

		return result;
	}
}