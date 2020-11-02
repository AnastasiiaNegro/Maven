import org.junit.Test;

public abstract class TestMain {
    public abstract IAnimal getName();

     @Test
     public void go() {
        IAnimal name = getName();
        String result = name.go();
        if (result == null || result.isEmpty()) {
            throw new RuntimeException("Method go is not implement");
        }
    }

    @Test
    public void getLegs() {
        IAnimal name = getName();
        Integer result = name.getLegs();
        if (result == null) {
            throw new RuntimeException("Error in getLegs method");
        }
        if (result < 2 || result > 4) {
            throw new RuntimeException("Error in getLegs method");
        }
    }

    @Test
    public void voice() throws VoiceException {
        IAnimal name = getName();
        String result = name.voice();
        if (result == null || result.isEmpty()) {
            throw new RuntimeException("Method voice is not implement");
        }
        if (result.length() > 10) {
            throw new RuntimeException("Exceeded the maximum capacity of the input field");
        }
        if (result.matches("[0-9]+")) {
            throw new RuntimeException("Invalid character");
        }
    }
}




