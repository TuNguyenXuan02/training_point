package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.*;
import vnu.uet.trainingpoint.model.DisciplinaryDecision;
import vnu.uet.trainingpoint.model.ExamDiscipline;
import vnu.uet.trainingpoint.model.Status;
import vnu.uet.trainingpoint.model.dto.SemesterDTO;
import vnu.uet.trainingpoint.repository.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Service
public class InitDBService {

    private ConsultantRepository consultantRepository;

    private UserRepository userRepository;

    private ClassesRepository classesRepository;

    private EvaluationFormRepository evaluationFormRepository;

    private EvaluationFormOfClassPresidentRepository evaluationFormOfClassPresidentRepository;

    private StudentRepository studentRepository;

    private PasswordEncoder passwordEncoder;

    private SemesterService semesterService;

    @Autowired
    public void setSemesterService(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setConsultantRepository(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setClassesRepository(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @Autowired
    public void setEvaluationFormRepository(EvaluationFormRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    @Autowired
    public void setEvaluationFormOfClassPresidentRepository(EvaluationFormOfClassPresidentRepository evaluationFormOfClassPresidentRepository) {
        this.evaluationFormOfClassPresidentRepository = evaluationFormOfClassPresidentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct //???????c g???i khi kh???i t???o h???t c??c bean
    public void init() {

        // init consultant
        if (consultantRepository.count() == 0) {
            User userConsultant1 = new User("van.ntt", "ROLE_CONSULTANT");
            Consultant consultant1 = new Consultant("TS. Nguy???n Th??? Thanh V??n", "??i???n t??? vi???n th??ng", userConsultant1);
            userConsultant1.setPassword(passwordEncoder.encode(userConsultant1.getPassword()));
            userRepository.save(userConsultant1);
            consultantRepository.save(consultant1);

            User userConsultant2 = new User("vinh.nv", "ROLE_CONSULTANT");
            Consultant consultant2 = new Consultant("TS. Nguy???n V??n Vinh", "C??ng Ngh??? Th??ng Tin", userConsultant2);
            userConsultant2.setPassword(passwordEncoder.encode(userConsultant2.getPassword()));
            userRepository.save(userConsultant2);
            consultantRepository.save(consultant2);

            User userConsultant3 = new User("vu.tm", "ROLE_CONSULTANT");
            Consultant consultant3 = new Consultant("TS. Tr???n Mai V??", "C??ng Ngh??? Th??ng Tin", userConsultant3);
            userConsultant3.setPassword(passwordEncoder.encode(userConsultant3.getPassword()));
            userRepository.save(userConsultant3);
            consultantRepository.save(consultant3);

            User userConsultant4 = new User("xiem.hv", "ROLE_CONSULTANT");
            Consultant consultant4 = new Consultant("TS. Ho??ng V??n Xi??m", "??i???n t??? vi???n th??ng", userConsultant4);
            userConsultant4.setPassword(passwordEncoder.encode(userConsultant4.getPassword()));
            userRepository.save(userConsultant4);
            consultantRepository.save(consultant4);

            User userConsultant5 = new User("tung.tt", "ROLE_CONSULTANT");
            Consultant consultant5 = new Consultant("TS. Tr???n Thanh T??ng", "C?? h???c k??? thu???t v?? T??? ?????ng h??a", userConsultant5);
            userConsultant5.setPassword(passwordEncoder.encode(userConsultant5.getPassword()));
            userRepository.save(userConsultant5);
            consultantRepository.save(consultant5);

            User userConsultant6 = new User("tung.hx", "ROLE_CONSULTANT");
            Consultant consultant6 = new Consultant("TS. Ho??ng Xu??n T??ng", "C??ng Ngh??? Th??ng Tin", userConsultant6);
            userConsultant6.setPassword(passwordEncoder.encode(userConsultant6.getPassword()));
            userRepository.save(userConsultant6);
            consultantRepository.save(consultant6);

            User userConsultant7 = new User("tuyen.td", "ROLE_CONSULTANT");
            Consultant consultant7 = new Consultant("TS. T??? ?????c Tuy??n", "??i???n t??? vi???n th??ng", userConsultant7);
            userConsultant7.setPassword(passwordEncoder.encode(userConsultant7.getPassword()));
            userRepository.save(userConsultant7);
            consultantRepository.save(consultant7);

            System.out.println("init consultant");


            //init class
            Classes classes1 = new Classes("QH-2016-C-A-CLC1", consultant1);
            Classes classes2 = new Classes("QH-2017-C-F", consultant2);
            Classes classes3 = new Classes("QH-2017-C-C", consultant3);
            Classes classes4 = new Classes("QH-2017-C-D", consultant4);
            Classes classes5 = new Classes("QH-2018-C-D", consultant5);
            Classes classes6 = new Classes("QH-2019-C-D", consultant6);
            Classes classes7 = new Classes("QH-2020-C-D", consultant7);
            classesRepository.save(classes1);
            classesRepository.save(classes2);
            classesRepository.save(classes3);
            classesRepository.save(classes4);
            classesRepository.save(classes5);
            classesRepository.save(classes6);
            classesRepository.save(classes7);
            System.out.println("init classes");

            User user = new User("admin", "ROLE_ADMIN");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            //init student

            if (studentRepository.count() == 0) {

                User user1 = new User("16020046");
                user1.setPassword(passwordEncoder.encode(user1.getPassword()));
                userRepository.save(user1);
                Student student1 = new Student("Nguy???n V??n M???nh", "B???c Giang",
                        LocalDate.of(1998, 7, 4),
                        "VN", user1, classes1);
                studentRepository.save(student1);

                User user2 = new User("16020280");
                user2.setPassword(passwordEncoder.encode(user2.getPassword()));
                userRepository.save(user2);
                Student student2 = new Student("Phan Tu???n Th??nh", "Th??i B??nh",
                        LocalDate.of(1998, 2, 22),
                        "VN", user2, classes1);
                studentRepository.save(student2);

                User user3 = new User("16020246");
                user3.setPassword(passwordEncoder.encode(user3.getPassword()));
                userRepository.save(user3);
                Student student3 = new Student("????o Tu???n Linh", "Y??n B??i",
                        LocalDate.of(1998, 12, 27),
                        "VN", user3, classes1);
                studentRepository.save(student3);

                User user4 = new User("16020047"); //16020047	V?? Duy M???nh	13/06/1998
                user4.setPassword(passwordEncoder.encode(user4.getPassword()));
                userRepository.save(user4);
                Student student4 = new Student("V?? Duy M???nh", "H??ng Y??n",
                        LocalDate.of(1998, 6, 13),
                        "VN", user4, classes1);
                studentRepository.save(student4);


                User user5 = new User("16020062", "ROLE_PRESIDENT"); //16020062	V?? Th??? Thanh L??m	22/02/1998
                user5.setPassword(passwordEncoder.encode(user5.getPassword()));
                userRepository.save(user5);
                Student student5 = new Student("V?? Th??? Thanh L??m", "Thanh H??a",
                        LocalDate.of(1998, 2, 22),
                        "VN", user5, classes1);
                studentRepository.save(student5);


                User user6 = new User("17020711", "ROLE_PRESIDENT"); //17020711	Nguy???n Th??? L??? H??	18/01/1999
                user6.setPassword(passwordEncoder.encode(user6.getPassword()));
                userRepository.save(user6);
                Student student6 = new Student("Nguy???n Th??? L??? H??", "H?? N???i",
                        LocalDate.of(1999, 1, 18),
                        "VN", user6, classes2);
                studentRepository.save(student6);


                User user7 = new User("17020965");//17020031	Nguy???n Th??? Ng???c Lan	25/08/1999
                user7.setPassword(passwordEncoder.encode(user7.getPassword()));
                userRepository.save(user7);
                Student student7 = new Student("D????ng Tu???n Ph????ng", "H?? N???i",
                        LocalDate.of(1999, 4, 9),
                        "VN", user7, classes2);
                studentRepository.save(student7);


                User user8 = new User("17021034");
                user8.setPassword(passwordEncoder.encode(user8.getPassword()));
                userRepository.save(user8);
                Student student8 = new Student("Tr???n M???nh Th???ng", "H???i D????ng",
                        LocalDate.of(1999, 5, 14),
                        "VN", user8, classes2);
                studentRepository.save(student8);


                User user9 = new User("17021111");
                user9.setPassword(passwordEncoder.encode(user9.getPassword()));
                userRepository.save(user9);
                Student student9 = new Student("?????ng S??n T??ng", "H???i Ph??ng",
                        LocalDate.of(1999, 6, 3),
                        "VN", user9, classes2);
                studentRepository.save(student9);


                User user10 = new User("17021119");
                user10.setPassword(passwordEncoder.encode(user10.getPassword()));
                userRepository.save(user10);
                Student student10 = new Student("Nguy???n Xu??n T???", "Th??i B??nh",
                        LocalDate.of(1999, 8, 3),
                        "VN", user10, classes2);
                studentRepository.save(student10);


                User user11 = new User("17020776"); //17020776	Tr????ng Vi???t Ho??ng	29/07/1999
                user11.setPassword(passwordEncoder.encode(user11.getPassword()));
                userRepository.save(user11);
                Student student11 = new Student("Tr????ng Vi???t Ho??ng", "Th??i B??nh",
                        LocalDate.of(1999, 7, 29),
                        "VN", user11, classes3);
                studentRepository.save(student11);


                User user12 = new User("17020809"); //17020809	Nguy???n Th??? Ng???c Huy???n	8/1/1999
                user12.setPassword(passwordEncoder.encode(user12.getPassword()));
                userRepository.save(user12);
                Student student12 = new Student("Nguy???n Th??? Ng???c Huy???n", "H???i D????ng",
                        LocalDate.of(1999, 1, 8),
                        "VN", user12, classes3);
                studentRepository.save(student12);


                User user13 = new User("17020867"); //17020867	Tr???n Quang Long	3/12/1999
                user13.setPassword(passwordEncoder.encode(user13.getPassword()));
                userRepository.save(user13);
                Student student13 = new Student("Tr???n Quang Long", "L???ng S??n",
                        LocalDate.of(1999, 12, 3),
                        "VN", user13, classes3);
                studentRepository.save(student13);


                User user14 = new User("17020876");  //17020876	Tr???n Th??? Th??y Mai	4/10/1999
                user14.setPassword(passwordEncoder.encode(user14.getPassword()));
                userRepository.save(user14);
                Student student14 = new Student("Tr???n Th??? Th??y Mai", "Th??i B??nh",
                        LocalDate.of(1999, 10, 4),
                        "VN", user14, classes3);
                studentRepository.save(student14);


                User user15 = new User("17021023", "ROLE_PRESIDENT"); //17021023	L???c Th??? Th???o	11/11/1999
                user15.setPassword(passwordEncoder.encode(user15.getPassword()));
                userRepository.save(user15);
                Student student15 = new Student("L???c Th??? Th???o", "H?? N???i",
                        LocalDate.of(1999, 11, 11),
                        "VN", user15, classes3);
                studentRepository.save(student15);


                User user16 = new User("17020670"); //17020670	L?? Qu???c ?????t	1/12/1999
                user16.setPassword(passwordEncoder.encode(user16.getPassword()));
                userRepository.save(user16);
                Student student16 = new Student("L?? Qu???c ?????t", "Th??i Nguy??n",
                        LocalDate.of(1999, 12, 1),
                        "VN", user16, classes4);
                studentRepository.save(student16);


                User user17 = new User("17020675"); //17020675	Nguy???n Ch?? ?????t	11/8/1999
                user17.setPassword(passwordEncoder.encode(user17.getPassword()));
                userRepository.save(user17);
                Student student17 = new Student("Nguy???n Ch?? ?????t", "B???c Ninh",
                        LocalDate.of(1999, 8, 11),
                        "VN", user17, classes4);
                studentRepository.save(student17);


                User user18 = new User("17020724"); //17020724	Nguy???n Thu H???ng	4/4/1999
                user18.setPassword(passwordEncoder.encode(user18.getPassword()));
                userRepository.save(user18);
                Student student18 = new Student("Nguy???n Thu H???ng", "B???c Giang",
                        LocalDate.of(1999, 4, 4),
                        "VN", user18, classes4);
                studentRepository.save(student18);


                User user19 = new User("17020753"); //17020753	D????ng V??n H??a	19/02/1999
                user19.setPassword(passwordEncoder.encode(user19.getPassword()));
                userRepository.save(user19);
                Student student19 = new Student("D????ng V??n H??a", "H???i Ph??ng",
                        LocalDate.of(1999, 2, 19),
                        "VN", user19, classes4);
                studentRepository.save(student19);


                User user20 = new User("17020770", "ROLE_PRESIDENT"); //17020770	Nguy???n Vi???t Ho??ng	13/04/1999
                user20.setPassword(passwordEncoder.encode(user20.getPassword()));
                userRepository.save(user20);
                Student student20 = new Student("Nguy???n Vi???t Ho??ng", "H??ng Y??n",
                        LocalDate.of(1999, 4, 13),
                        "VN", user20, classes4);
                studentRepository.save(student20);


                User user21 = new User("18020251"); //18020251	L?? M???nh C?????ng	17/05/2000
                user21.setPassword(passwordEncoder.encode(user21.getPassword()));
                userRepository.save(user21);
                Student student21 = new Student("L?? M???nh C?????ng", "H???i Ph??ng",
                        LocalDate.of(2000, 5, 17),
                        "VN", user21, classes5);
                studentRepository.save(student21);


                User user22 = new User("18020640"); //18020640	Nguy???n Qu???c Huy	27/08/2000
                user22.setPassword(passwordEncoder.encode(user22.getPassword()));
                userRepository.save(user22);
                Student student22 = new Student("Nguy???n Qu???c Huy", "H???i Ph??ng",
                        LocalDate.of(2000, 8, 27),
                        "VN", user22, classes5);
                studentRepository.save(student22);


                User user23 = new User("18020661", "ROLE_PRESIDENT"); //18020661	Tr???n Nguy???n Quang Huy	5/12/2000
                user23.setPassword(passwordEncoder.encode(user23.getPassword()));
                userRepository.save(user23);
                Student student23 = new Student("Tr???n Nguy???n Quang Huy", "H??ng Y??n",
                        LocalDate.of(2000, 12, 5),
                        "VN", user23, classes5);
                studentRepository.save(student23);


                User user24 = new User("18021124"); //18021124	Ph???m Tr???ng T???n	26/08/2000
                user24.setPassword(passwordEncoder.encode(user24.getPassword()));
                userRepository.save(user24);
                Student student24 = new Student("Ph???m Tr???ng T???n", "H?? N???i",
                        LocalDate.of(2000, 8, 26),
                        "VN", user24, classes5);
                studentRepository.save(student24);


                User user25 = new User("18021140");//18021140	Ph???m Vi???t Th???ng	20/10/2000
                user25.setPassword(passwordEncoder.encode(user25.getPassword()));
                userRepository.save(user25);
                Student student25 = new Student("Ph???m Vi???t Th???ng", "H??ng Y??n",
                        LocalDate.of(2000, 10, 20),
                        "VN", user25, classes5);
                studentRepository.save(student25);


                User user26 = new User("19020218"); //19020218	Nguy???n Cao B??ch	26/08/2001
                user26.setPassword(passwordEncoder.encode(user26.getPassword()));
                userRepository.save(user26);
                Student student26 = new Student("Nguy???n Cao B??ch", "H???i D????ng",
                        LocalDate.of(2001, 8, 26),
                        "VN", user26, classes6);
                studentRepository.save(student26);


                User user27 = new User("19020288", "ROLE_PRESIDENT");//19020288	Tr????ng Xu??n Hi???u	11/11/2001
                user27.setPassword(passwordEncoder.encode(user27.getPassword()));
                userRepository.save(user27);
                Student student27 = new Student("Tr????ng Xu??n Hi???u", "H?? N???i",
                        LocalDate.of(2001, 11, 11),
                        "VN", user27, classes6);
                studentRepository.save(student27);


                User user28 = new User("19020388"); //19020388	V?? Ph??ng B???o Nh???t	27/01/2000
                user28.setPassword(passwordEncoder.encode(user28.getPassword()));
                userRepository.save(user28);
                Student student28 = new Student("V?? Ph??ng B???o Nh???t", "H?? N???i",
                        LocalDate.of(2000, 1, 27),
                        "VN", user28, classes6);
                studentRepository.save(student28);


                User user29 = new User("19020403"); //19020403	Nguy???n V??n Quang	16/09/2001
                user29.setPassword(passwordEncoder.encode(user29.getPassword()));
                userRepository.save(user29);
                Student student29 = new Student("Nguy???n V??n Quang", "H???i Ph??ng",
                        LocalDate.of(2001, 9, 16),
                        "VN", user29, classes6);
                studentRepository.save(student29);


                User user30 = new User("19020458"); //19020458	L?? C???nh To??n	26/05/2001
                user30.setPassword(passwordEncoder.encode(user30.getPassword()));
                userRepository.save(user30);
                Student student30 = new Student("L?? C???nh To??n", "H??ng Y??n",
                        LocalDate.of(2001, 5, 26),
                        "VN", user30, classes6);
                studentRepository.save(student30);


                User user31 = new User("20020357"); //20020357	B??i Tu???n Anh	7/3/2002
                user31.setPassword(passwordEncoder.encode(user31.getPassword()));
                userRepository.save(user31);
                Student student31 = new Student("B??i Tu???n Anh", "H???i Ph??ng",
                        LocalDate.of(2002, 3, 7),
                        "VN", user31, classes7);
                studentRepository.save(student31);


                User user32 = new User("20020359", "ROLE_PRESIDENT"); //20020359	Nguy???n Quang Anh	23/10/2002
                user32.setPassword(passwordEncoder.encode(user32.getPassword()));
                userRepository.save(user32);
                Student student32 = new Student("Nguy???n Quang Anh", "H?? N???i",
                        LocalDate.of(2002, 10, 23),
                        "VN", user32, classes7);
                studentRepository.save(student32);


                User user33 = new User("20020096"); //20020096	Nguy???n Th??? Anh	17/11/2002
                user33.setPassword(passwordEncoder.encode(user33.getPassword()));
                userRepository.save(user33);
                Student student33 = new Student("Nguy???n Th??? Anh", "Qu???ng Ninh",
                        LocalDate.of(2002, 11, 17),
                        "VN", user33, classes7);
                studentRepository.save(student33);


                User user34 = new User("20020360"); //20020360	Nguy???n V?? Anh	9/6/2002
                user34.setPassword(passwordEncoder.encode(user34.getPassword()));
                userRepository.save(user34);
                Student student34 = new Student("Nguy???n V?? Anh", "H?? N???i",
                        LocalDate.of(2002, 6, 9),
                        "VN", user34, classes7);
                studentRepository.save(student34);


                User user35 = new User("20020363");//20020363	V?? Huy Anh	28/11/2002
                user35.setPassword(passwordEncoder.encode(user35.getPassword()));
                userRepository.save(user35);
                Student student35 = new Student("V?? Huy Anh", "Qu???ng Ninh",
                        LocalDate.of(2002, 11, 20),
                        "VN", user35, classes7);
                studentRepository.save(student35);
                System.out.println("init student");


                // init hoc ky truoc
                semesterService.addSuccess(new SemesterDTO(184)); // HK I  2017-2018
                semesterService.addSuccess(new SemesterDTO(185)); // HK II 2017-2018

                semesterService.addSuccess(new SemesterDTO(187)); // HK I  2018-2019
                semesterService.addSuccess(new SemesterDTO(188)); // HK II 2018-2019

                semesterService.addSuccess(new SemesterDTO(190)); // HK I  2019-2020
                semesterService.addSuccess(new SemesterDTO(191)); // HK II 2019-2020

                semesterService.addSuccess(new SemesterDTO(193)); // HK I  2020-2021
//                semesterService.add(new SemesterDTO(194, LocalDate.of(2021, 8, 3))); // HK II 2020-2021

                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 2) {
                        continue;
                    }
                    EvaluationForm evaluationForm = evaluationFormRepository
                            .findByUsernameAndSemester("17021119", 184 + i).get();
                    evaluationForm.setTotalPoint(70 + 3 * i);
                    evaluationFormRepository.save(evaluationForm);
                }

//                EvaluationForm e = evaluationFormRepository.findByUsernameAndSemester("17021119", 194).get();
//                e.setHoc_luc_yeu(false);
//                e.setCanh_cao_hoc_vu(false);
//                e.setDang_ki_khong_du_tin(false);
//                e.setCam_thi_bo_thi(2);
//                e.setKy_luat_thi(ExamDiscipline.DINH_CHI);
//
//                //2. ?? th???c v?? k???t qu??? ch???p h??nh n???i quy, quy ch??? c???a nh?? tr?????ng
//                e.setNop_nhan_kinh_phi(1);
//                e.setDang_ki_hoc_qua_han(false);
//                e.setKhong_thuc_hien_yeu_cau(1);
//                e.setTra_qua_han_giay_to(1);
//                e.setKhong_tham_gia_bao_hiem(false);
//                e.setVi_pham_quy_dinh_cu_tru(0);
//                e.setQuyet_dinh_ky_luat(DisciplinaryDecision.PHE_BINH);
//
//                //3. ?? th???c v?? k???t qu??? than gia haojt ?????ng ch??nh tr???- v??n h??a, x?? h???i...
//                e.setTham_gia_chi_doan_chinh_tri(false);
//                e.setTham_gia_hoat_dong(2);
//                e.setKhong_tham_gia_sinh_hoat(3);
//                //4. v??? ph???m ch???t c??ng d??n v?? quan h??? v???i c???ng ?????ng
//                e.setKhong_chap_hanh_luat(1);
//                e.setKhong_co_tinh_than_doan_ket(2);
//
//                //5. ?? th???c v?? k???t qu??? tham gia c??ng t??c ph??? tr??ch l???p, c??c ??o??n th???, t??? ch???c trong nh?? tr?????ng, ho???c ?????t
//                // ???????c th??nh t??ch ?????c bi???t trong h???c t???p, r??n luy???n c???a h???c sinh, sinh vi??n
//                e.setGiu_chuc_vu(true);
//                e.setHoc_luc_gioi_xuat_sac(true);
//                e.setChung_chi_tieng_Anh(true);
//                e.setTham_gia_cuoc_thi(4);
//                e.setDat_giai_cuoc_thi(true);
//                e.setTham_gia_NCKH(false);
//                e.setDat_giai_NCKH(false);
//                e.setKet_nap_Dang(false);
//                e.setEvaluationFormOfClassPresident(null);
//
//                e.setStatus(Status.NEED_STUDENT_FILL);
//                e.setTotalPoint(e.autoGenerateTotalPoint());
//                evaluationFormRepository.save(e);

            }
        }
    }
}
