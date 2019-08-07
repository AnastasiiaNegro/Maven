public class TestCat {
    Cat cat = new Cat();

    public void testGoNethod() {
        String result = cat.go();
        if (result == null || result.isEmpty()) {
            throw new RuntimeException("Method is not implement");
        }
    }
    public void testGetLegsNethod(){
        Integer result = cat.getLegs();
        if (result == null || result <4) {
            throw  new RuntimeException("Error in getLegs method");
        }
    }
}
