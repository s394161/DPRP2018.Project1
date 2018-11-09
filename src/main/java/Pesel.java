public class Pesel {

    private final static int[] VALID_NUMBERS = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

    private String pesel;

    public Pesel() {
    }

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    boolean isPeselValid() {
        if (pesel.length() != 11) {
            System.out.println("Podany PESEL ma niewłaściwą długość.");
            return false;
        }
        int sum = 0;
        for (int i = 0; i < pesel.length() - 1; i++) {
            sum = sum + VALID_NUMBERS[i] * Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }
        String stringSum = String.valueOf(sum);
        int lastSumDigit = Integer.parseInt(String.valueOf(stringSum.charAt(stringSum.length() - 1)));
        int lastPeselDigit = Integer.parseInt(String.valueOf(pesel.charAt(pesel.length() - 1)));
        if (lastPeselDigit == lastSumDigit) {
            System.out.println("Podany numer PESEL jest poprawny.");
            return true;
        } else {
            System.out.println("Podany numer PESEL jest błędny.");
            return false;
        }
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return pesel;
    }
}
