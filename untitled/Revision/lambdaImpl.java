package Revision;

public class lambdaImpl {
    public static void main(String[] args) {
        Square  square = a->a*a;
        System.out.println(square.square(100));

        Cube cube = (a)->{
            return (int) Math.pow(a,3);
        };
        System.out.println(cube.cube(10));

        Modulo modulo = (a,b)->{return a%b;};
        System.out.println(modulo.modulo(947,123));

        factorial fact = (a)->{
            int res = 1;
            while (a > 0)
            {
                res = res * a;
                a--;
            }
            return  res;
        };
        System.out.println(fact.fact(5));

        GenericLambda<String> genericLambda = (str) ->{
            return str.substring(2);
        };

        System.out.println(genericLambda.func("abcdef"));

        GenericLambda<Integer> integerGenericLambda = (i)->{
            int j =1;
            while (i>0){
                j = j*i;
                i--;
            }
            return j;
        };
        System.out.println(integerGenericLambda.func(5));
    }
}
