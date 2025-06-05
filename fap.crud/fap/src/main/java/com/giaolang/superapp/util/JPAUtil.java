package com.giaolang.superapp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    //class nay chua ham static de cung cap service ket noi toi csdl nao do
    // no khoi dong 1 lan duy nhat khi app dc khoi dong, tranh moi lan no khoi dong, no se doc lai thong so ket noi, csdl va no se co kha nang reset database (tuy option trong file persistence.xml)

    private static final String PERSISTENCE_UNIT = "com.giaolang.superapp-PU";
    private static EntityManagerFactory emf;

    // khoi lenh static se duoc chay duy nhat mot lan khi class nay duoc cham vao dau tien
    // doan code nay hay dung cho viec khoi dong nhung gia tri gi do
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            //ki thuat viet code ma chi co 1 object duoc tao ra, ko co 2 nhat new() cai gi do, ki thuat nay goi la SINGLETON
            // lam sao co singleton: non-static bat thanh singleton
        }
        catch (Exception e) {
            System.out.println("Failed to initialize EntityManagerFactory");
            throw new RuntimeException(e);
        }
        //ham tra ra ong sep entity manager cho cac noi khac xai de quan ly cac entity khac

    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    // doi khi ta can xai truc tiep ong emf (ong ket noi) thi ta tra them ong nay
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    //dong ket noi emf
    public static void closeEntityManager(EntityManager em) {
        em.close();
    }
}
