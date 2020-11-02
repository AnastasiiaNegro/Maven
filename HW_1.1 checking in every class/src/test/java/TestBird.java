public class TestBird {
    Bird bird = new Bird();

    public void testGoNethod() {
        String result = bird.go();
        if (result == null || result.isEmpty()) {
            throw new RuntimeException("Method is not implement");
        }
    }

    public void testGetLegsNethod() {
        Integer result = bird.getLegs();
        if (result == null || result < 2) {
            throw new RuntimeException("Error in getLegs method");
        }
    }
}
