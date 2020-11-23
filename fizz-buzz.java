class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> str = new ArrayList<>();
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzbuzz = "FizzBuzz";
        
        for(int i = 1; i < n+1; i++) {
            if(i%3 == 0 && i%5 == 0) str.add(fizzbuzz); //System.out.println("Fizzbuzz");
            else if(i%3 == 0) str.add(fizz); //System.out.println("Fizz");
            else if (i%5 == 0) str.add(buzz); //System.out.println("Buzz");
            else str.add(Integer.toString(i)); //System.out.println(i);
        }
        return str;
    }
}
