package TestContext;

public class TestContext {
    public static String userLogin;
    public static UserRoles userRole;


    public static void setUserRoleByLogin(String login){
        userLogin = login;
        if( login.equals("azimovqobil72@gmail.com")){
            userRole = UserRoles.BUYER_COMPANY_ADMIN;
        }else if(login.equals("Jahongir026567+1@gmail.com")){
            userRole = UserRoles.SELLER;
        }
    }
}
