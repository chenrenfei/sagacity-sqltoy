import helper.QueryHelper;
import vo.SysLocationVO;

public class TtService {

    private Integer count = new Integer(0);

    public String sayHello(String name) {
        SysLocationVO sysLocationVO = new SysLocationVO();
//        sysLocationVO.setLocationId(1L);
        sysLocationVO.setLocationName("ddddd");
//        sysLocationVO.setOnlinePersion(0L);
//        sysLocationVO.setTotalPersion(0L);
        QueryHelper.save(sysLocationVO);
        QueryHelper.flush();
//        QueryHelper.read(sysLocationVO);
//        QueryHelper.read("sys_location_list",SysLocationVO.class);
        System.out.println("Ttservice.sayhello" + (count++));
        return "nihao " + name;
    }

}

