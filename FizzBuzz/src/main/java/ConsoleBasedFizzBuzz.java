// class implements interface
class ConsoleBasedFizzBuzz implements FizzBuzz {
    public void print(int from, int to) {
        System.out.println("Printing from " + from + " to " + to);
        for (int i = from; i <= to; i++) {
            //Calculate modulos (in i % x are 0 if x is devider of i)
            int modu3= i % 3;
            int modu5= i % 5;

            if (modu3 ==0 && modu5!=0) { //only devider 3
                System.out.println("Fizz");
            } else if (modu3 !=0 && modu5==0) { //only devider 5
                System.out.println("Buzz");
            } else if (modu3 == 0) { //both deviders
                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);
            }

        }
    }
}

