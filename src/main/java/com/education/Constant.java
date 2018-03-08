package com.education;

public class Constant {
    private Constant(){}

    public static final String STORAGE_ATTRIBUTE = "storage";
    public static final String ADD_USER_PAGE = "/WEB-INF/pages/add_user_page.jsp";
    public static final String DELETE_USER_PAGE = "/WEB-INF/pages/delete_user_page.jsp";
    public static final String DISPLAY_USER_PAGE = "/WEB-INF/pages/display_user_page.jsp";
    public static final String LOGIN_PAGE = "/login.jsp";
    public static final String INDEX_PAGE = "/WEB-INF/pages/index.jsp";
    public static final String FIND_USER_PAGE = "/WEB-INF/pages/find_user_page.jsp";
    public static final String ERROR_PAGE = "/WEB-INF/pages/error_page.jsp";

    public static final String ERROR_PAGE_REDIRECT_URL = "/error.html";
    public static final String INDEX_PAGE_REDIRECT_URL = "/index.html";

    //sessions attributes
    public static final String SESSION_IS_USER_ACTIVE_ATTR_NAME = "isUserActive";

    //http req attributes
    public static final String ERROR_MESSAGE_ATTR_NAME = "error_message";
}
