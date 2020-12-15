package listamosului.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
	
	private static DataValidation instance = null;
	
	private DataValidation() {}
	
	public static DataValidation getInstance() {
		if(instance == null) {
			instance = new DataValidation();
		}
		
		return instance;
	}

	public boolean checkEmail(String email) {
        if(email == null || email.equals("")) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\n" +
                    "\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\n" +
                    "\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:\n" +
                    "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
            Matcher matcher = pattern.matcher(email);
            if(matcher.find()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkFName(String name) {
        if(name == null || name.equals("")) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("[0-9]+|[,./><?|'\";:!@#$%^&*()_+={}\\[\\]]+");
            Matcher matcher = pattern.matcher(name);
            if(matcher.find()) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean checkLName(String name) {
        if(name == null || name.equals("")) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("[0-9]+|[,./><?|'\";:!@#$%^&*()_+={}\\[\\]]+");
            Matcher matcher = pattern.matcher(name);
            if(matcher.find()) {
                return false;
            } else {
                return true;
            }
        }
    }
    
    public boolean checkUsername(String username) {
    	if(username == null || username.equals("")) {
    		return false;
    	} else {
    		Pattern pattern = Pattern.compile("[,./><?|'\";:!@#$%^&*()_+={}\\[\\]]+");
            Matcher matcher = pattern.matcher(username);
            if(matcher.find()) {
            	return false;
            } else {
            	return true;
            }
    	}
    }
    
    public boolean checkPassword(String password) {
    	if(password == null || password.equals("")) {
    		return false;
    	} else {
    		Pattern pattern = Pattern.compile("[,./><|'\";:@#$%^&*()={}\\[\\]]+");
            Matcher matcher = pattern.matcher(password);
            if(matcher.find()) {
            	return false;
            } else {
            	pattern = Pattern.compile("[?!+_]+");
                matcher = pattern.matcher(password);
            	return matcher.find() ? true : false;
            }
    	}
    }
    
    public boolean checkAddress(String address) {
    	if(address == null || address.equals("")) {
    		return false;
    	} else {
    		Pattern pattern = Pattern.compile("[/><|'\";:@#$%^&*()={}\\[\\]]+");
            Matcher matcher = pattern.matcher(address);
            if(matcher.find()) {
            	return false;
            } else {
            	
            	return true;
            }
    	}
    }
    
    public boolean checkDate(String bday) {
    	if(bday == null || bday.equals("")) {
    		return false;
    	} else {
    		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                sdf.parse(bday);
            } catch (ParseException e) {
                return false;
            }
            return true;
    	}
    }
    
    public LocalDate convertStringToLocalDate(String date) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    	LocalDate localDate = LocalDate.parse(date, formatter);
    	
    	return localDate;
    }
}
