public class TestDog {
    Dog dog = new Dog();

    public void testGoNethod() {
        String result = dog.go();
        if (result == null || result.isEmpty()) {
            throw new RuntimeException("Method is not implement");
        }
    }

    public void testGetLegsNethod() {
        Integer result = dog.getLegs();
        if (result == null || result < 4) {
            throw new RuntimeException("Error in getLegs method");
        }
    }
}
