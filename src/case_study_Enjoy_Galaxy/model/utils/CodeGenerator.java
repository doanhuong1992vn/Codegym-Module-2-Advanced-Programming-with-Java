package case_study_Enjoy_Galaxy.model.utils;

public class CodeGenerator {
//    private static final CodeGenerator codeGenerator = new CodeGenerator();
//    private CodeGenerator(){
//    }
//    public static CodeGenerator getInstance() {
//        return codeGenerator;
//    }
    public static StringBuilder getCodeOfName(String name) {
        String[] arrayOfWordsInMovieTheaterName = name.split(" ");
        StringBuilder code = new StringBuilder();
        for (String word : arrayOfWordsInMovieTheaterName) {
            code.append(word.charAt(0));
        }
        return code;
    }
}
