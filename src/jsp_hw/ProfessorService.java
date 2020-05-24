package jsp_hw;

import jsp_hw.utils.StringUtil;

public class ProfessorService {

    static final String 이름_필수 = "이름을 입력하세요";
    static final String 교번_중복 = "교번이 중복됩니다.";


    public static String validate(Professor professor) throws Exception {
        if (StringUtil.isEmptyOrBlank(professor.getProfessorName()))
            return 이름_필수;
        Professor professor1 = ProfessorDAO.findById(professor.getId());
        if (professor1 != null && professor1.getId() != professor.getId())
            return 교번_중복;

        return null;
    }

    public static String insert(Professor professor) throws Exception {
        String errorMessage = validate(professor);
        if (errorMessage != null) return errorMessage;
        ProfessorDAO.insert(professor);
        return null;
    }

    public static String update(Professor professor) throws Exception {
        String errorMessage = validate(professor);
        if (errorMessage != null) return errorMessage;
        ProfessorDAO.update(professor);
        return null;
    }
}
