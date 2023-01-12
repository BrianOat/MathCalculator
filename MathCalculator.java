public class MathCalculator {
    public String Calculus2Catalog(){
        return "Definite Integral, Indefinite Integral";
    }
    public static boolean SingleTerm(String function){
        for(int i = 0; i<function.length(); i++){
            if(function.substring(i,i+1).equals(" "))
                return false;
        }
        return true;
    }
    public static boolean isInteger(String num){
        try{
            Integer.parseInt(num);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    public static String[] FunctionIntoArray(String function){
        int operationCounter = 0;
        for(int i=0; i<function.length(); i++){
            if(function.substring(i, i+1).equals(" ")){
                operationCounter++;
            }
        }
        String[] arr = new String[operationCounter/2 +1];
        int arrI = 0;
        for(int i=0; i<arr.length;i++){
            arr[i]="";
        }
        for(int i=0; i<function.length(); i++) {
            if (function.substring(i, i + 1).equals(" ")){
                i+=3;
                arrI++;
        }
            arr[arrI] += function.substring(i, i+1);
        }
        return arr;
    }
    public static String[] FractionIntoArray(String function){
       String[] arr = new String[2];
       int indexCounter = -1;
       for(int i=0; i<function.length();i++){
           indexCounter++;
           if(function.substring(i,i+2).equals("//")){
               break;
           }
       }
       arr[0] = function.substring(1,indexCounter);
       arr[1] = function.substring(indexCounter+2, function.length()-1);
        return arr;
    }

    public static boolean isPolynomial(String function){ //by what i call a polynomial
        try{for(int i =0; i<function.length();i++){
            if(function.substring(i, i+1).equals("x") && function.substring(i+1, i+2).equals("^"))
                return true;
        }}
        catch(StringIndexOutOfBoundsException e){
            return true;
        }
        try{
            int num = Integer.parseInt(function);
            return true;
        }
        catch(Exception e){

        }
        return false;
    }
    public static boolean isTrigonometric(String function){
        for (int i = 0; i <= function.length()-3; i++) {
            if(function.substring(i, i + 3).equals("sin") || function.substring(i, i + 3).equals("cos")
                || function.substring(i, i + 3).equals("tan") || function.substring(i, i + 3).equals("csc")
            ||function.substring(i, i + 3).equals("sec") || function.substring(i, i + 3).equals("cot"))
                return true;
            }
        return false;
    }
    public static boolean isExponential(String function) {
        try{
        for (int i = 0; i < function.length(); i++){
            if (!function.substring(i, i + 2).equals("x^") && function.substring(i, i+1).equals("^"))
                return true;
    }
        }
        catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }
    public static boolean isLogarithmic(String function) {
        for(int i = 0; i < function.length(); i++) {
            if (function.substring(i,i+1).equals("_"))
                return true;
        }
        return false;
    }
    public static boolean isFraction(String function) {
        for (int i = 0; i < function.length(); i++) {
            if (function.substring(i, i + 1).equals("{")) {
                return true;
            }
        }
        return false;
    }
    public static int expo(int base, int power){
        if(power == 0)
            return 1;
        return base*expo(base, power-1);
    }
    public static double expo(){
        return 0;
    }
    public static double  sqrt(double num){
        return 0;
    }
    public static String DerivativePowerRule(String function){
        String coefficient="";
        try{
            int num = Integer.parseInt(function);
            return "0";
        }
        catch(Exception e ){
        }
        if(function.charAt(0)=='x') {
            function = "1"+function;
        }
        int power=0;
        String powerStr="";
        String[] functionArr = new String[function.length()];
        for(int i= 0; i<functionArr.length; i++){
            functionArr[i] = "" + function.charAt(i);
        }
        for(int i = 0; i<functionArr.length; i++){
            if(functionArr[i].equals("x"))
                break;
            coefficient += functionArr[i];
        }
        for(int i = 0; i<functionArr.length; i++) {
            if (functionArr[i].equals("^")){
                for (int j = i + 1; j < functionArr.length; j++) {
                    powerStr += functionArr[j];
                }
                power = Integer.parseInt(powerStr);
            }
        }
        if(power==0 || power==1){
            return coefficient;
        }
        String[] answerArr = new String[6];
        answerArr[0] = coefficient + "*" + power ;
        answerArr[1] = "x";
        answerArr[2] = "^";
        answerArr[3] = String.valueOf(power-1);
        answerArr[4] = "";
        answerArr[5] = "";
        String answer = "";
        for (int i=0; i<answerArr.length; i++) {
            answer += answerArr[i];
        }
        answer = Simplify(answer);
        return answer;
    }
    public static String TrigonometricDerivatives(String function){
        String sinx = "cos(x)"; String cosx = "-sin(x)"; String tanx = "sec^2(x)";
        String secx = "sec(x)tan(x)"; String cscx = "-csc(x)cot(x)"; String cotx = "-csc^2(x)";
        if(function.equals("sin(x)"))
            return sinx;
        if(function.equals("cos(x)"))
            return cosx;
        if(function.equals("tan(x)"))
            return tanx;
        if(function.equals("sec(x)"))
            return secx;
        if(function.equals("csc(x)"))
            return cscx;
        if(function.equals("cot(x)"))
            return cotx;
        return "I can't solve :(";
    }
    public static String Derive(String function){
        String finalAns = "";
        boolean isTrig = isTrigonometric(function);
        boolean isExpo = isExponential(function);
        boolean isLog = isLogarithmic(function);
        boolean isPoly = isPolynomial(function);
        boolean isFrac = isFraction(function);
        if(isPoly){
            if(!SingleTerm(function)) {
                String[] pArr = FunctionIntoArray(function);
                for (String obj : pArr) {
                    finalAns += (DerivativePowerRule(obj)) + " + ";
                }
                finalAns = finalAns.substring(0, finalAns.length()-3);
                return finalAns;
            }
            else{
                return DerivativePowerRule(function);
            }
        }
        if(isTrig){
            String[] tArr = FunctionIntoArray(function);
            for(String obj: tArr){
                finalAns+=(TrigonometricDerivatives(obj));
            }
            return finalAns;
        }
        return "I cannot solve :(";
    }
    public static String IntegrationPowerRule(String function){
        String coefficient="";
        //In this for loop it keeps checking a substring of 4 characters until it matches, if no match then its a
        //coefficient
        try{for(int i=0; i<function.length();i++){
            if(function.substring(i,i+4).equals("x^-1")){
                return coefficient + "ln(x)";
            }
            coefficient+= function.substring(i,i+1);
        }
        }
        catch(IndexOutOfBoundsException e){
            coefficient = "";
        }
        if(function.charAt(0)=='x' && function.length()==1) {
            return "1/2x^2";
        }
        int power=0;
        String powerStr="";
        String[] functionArr = new String[function.length()];
        for(int i= 0; i<functionArr.length; i++){
            functionArr[i] = "" + function.charAt(i);
        }
        for(int i = 0; i<functionArr.length; i++){
            if(functionArr[i].equals("x"))
                break;
            coefficient += functionArr[i];
        }
        for(int i = 0; i<functionArr.length; i++) {
            if (functionArr[i].equals("^")){
                for (int j = i + 1; j < functionArr.length; j++) {
                    powerStr += functionArr[j];
                }
                power = Integer.parseInt(powerStr);
            }
        }
        String[] answerArr = new String[6];
        if(coefficient.equals(""))
            coefficient = "1";
        answerArr[0] = coefficient + "/" + (power+1);
        answerArr[1] = "x";
        answerArr[2] = "^";
        answerArr[3] = String.valueOf(power+1);
        answerArr[4] = "";
        answerArr[5] = "";
        String answer = "";
        for (int i=0; i<answerArr.length; i++) {
            answer += answerArr[i];
        }
        answer = Simplify(answer);
        return answer;
    }
    public static String indefiniteIntegral(String function) {
        String finalAns = "";
        boolean isTrig = isTrigonometric(function);
        boolean isExpo = isExponential(function);
        boolean isLog = isLogarithmic(function);
        boolean isPoly = isPolynomial(function);
        boolean isFrac = isFraction(function);
        if(isTrig == true && isPoly == true && isFrac == true){
            //Work in Progress
//            if(!SingleTerm(function)){
//                String[] fArr = FunctionIntoArray(function);
//                for(String obj: fArr){
//                finalAns += indefiniteIntegral(obj) + " + ";
//                }
//                finalAns = finalAns.substring(0, finalAns.length()-3);
//                return finalAns;
//            }
//            return "";
        }
        if(isTrig==true && isExpo == true){

        }
        if(isTrig==true && isFrac==true){
            String[] fArr = FractionIntoArray(function);
            return uSubFraction(fArr);
        }
        if(isPoly && isFrac){
            String[] fArr = FractionIntoArray(function);
            return uSubFraction(fArr);
        }
        if(isFrac==true){
            String[] fArr = FractionIntoArray(function);
            if(fArr[1].equals("x")){
                function = "x^-1";
            }
        }
        if(isPoly == true){
            if(!SingleTerm(function)) {
                String[] pArr = FunctionIntoArray(function);
                for (String obj : pArr) {
                    finalAns += (IntegrationPowerRule(obj)) + " + ";
                }
                finalAns = finalAns.substring(0, finalAns.length()-3);
                return finalAns;
            }
            else{
                return IntegrationPowerRule(function);
            }
        }
        if(isTrig==true){
            if(!SingleTerm(function)){
            String[] tArr = FunctionIntoArray(function);
            for(String obj: tArr){
                finalAns+=(TrigonometricIntegrals(obj) + " + ");
             }
                finalAns = finalAns.substring(0, finalAns.length()-3);
                return finalAns;
            }
            else{
                return TrigonometricIntegrals(function);
            }
        }
        return "I cannot solve :(";
    }
    public static String TrigSubstitution(){
        return "";
    }
    public static double definiteIntegral(int a, int b, String function){
        indefiniteIntegral(function);
        return 0;
    }
    public static String Simplify(String function){
        String coefficient = "";
        String num = "";
        String operation = "";
        int indexCounter = -1;
        for(int i=0; i<function.length();i++){
            indexCounter++;
            if(!isInteger(function.substring(i,i+1))){
                operation = function.substring(i, i+1);
                for(i=indexCounter+1; i<function.length();i++){
                    indexCounter++;
                    if(!isInteger(function.substring(i,i+1))){
                        break;
                    }
                    num+=function.substring(i, i+1);
                }
                break;
            }
            coefficient+=function.substring(i, i+1);
        }
        int co = Integer.parseInt(coefficient);
        int pow = Integer.parseInt(num);
        if(operation.equals("*")){
            coefficient = String.valueOf(co*pow);
            if(coefficient.equals("1")){
                coefficient = "";
            }
            return (coefficient + function.substring(indexCounter));
        }
        if(operation.equals("/")){
            if(co>pow || co==pow){
                coefficient = String.valueOf(co/pow);
            if(coefficient.equals("1") || co%pow ==0){
                coefficient = "";
            }
            if(coefficient.equals("1") || co%pow !=0){
                return function;
            }
            return (coefficient + function.substring(indexCounter));
            }
            if(co<pow){
                return function;
            }
        }
        return "Work in Progress";
    }
    public static String SimplifyLikeTerms(String function){
        return "Work in Progress";
        //this function will simplify when u have an output that can be added together like ln(x) + ln(x) = 2ln(x)
    }
    public static String TrigonometricIntegrals(String function){
        String sinx = "-cos(x)"; String cosx = "sin(x)"; String sec2x = "tan(x)";
        String secxtanx = "sec(x)"; String csc2x = "cot(x)"; String cscxcotx = "csc(x)";
        if(function.equals("sin(x)"))
            return sinx;
        if(function.equals("cos(x)"))
            return cosx;
        if(function.equals("sec^2(x)"))
            return sec2x;
        if(function.equals("sec(x)tan(x)"))
            return secxtanx;
        if(function.equals("-csc^2(x)"))
            return csc2x;
        if(function.equals("-csc(x)cot(x)"))
            return cscxcotx;
        return "I can't solve :(";
    }
    public static String uSubFraction(String[] function){
        String u = "";
        String du = "";
        String uFunction = "";
        if(TrigonometricDerivatives(function[1]).equals(function[0])) {
            u = function[1];
            du = "1";
            uFunction = "x^-1";
            String uIntegral = indefiniteIntegral(uFunction);
            String finalAnswer = uIntegral.replaceAll("x", u);
            return finalAnswer;
        }
        if(Derive(function[1]).equals(function[0])) {
            u = function[1];
            du = "1";
            uFunction = "x^-1";
            String uIntegral = indefiniteIntegral(uFunction);
            String finalAnswer = uIntegral.replaceAll("x", u);
            return finalAnswer;
        }
        return "I can't solve :(";
    }
}
