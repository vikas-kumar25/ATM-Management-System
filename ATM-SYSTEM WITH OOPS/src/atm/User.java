package atm;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class User
{
    private String name;
    private int pin;

    public User(String name, int pin)
    {
        this.name = name;
        this.pin = pin;
    }

    //Getting user name-----------------------------------------
    public String getName()
    {
        return name;
    }

    //Pin Validation---------------------------------------------
    public boolean verifyPin(int atmPin)
    {

        if (atmPin == pin)
        {
            return true;
        } else
        {
            return false;
        }
    }

    //PIN CHANGE FUNCTION-----------------------------------------
    public boolean changePin(int currentPin, int newPin)
    {

        // Verify the current PIN
        if (currentPin != pin)
        {
            return false;
        }

        // Validate the new PIN
        if (newPin < 1000 || newPin > 9999)
        {
            return false;
        }

        // Update the PIN
        pin = newPin;

        return true;
    }
}
