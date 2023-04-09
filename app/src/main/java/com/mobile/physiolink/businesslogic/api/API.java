/**
 * @author Kote Kostandin (setokk) <br>
 * <a href="https://www.linkedin.com/in/kostandin-kote-255382223/">LinkedIn</a>
 * <br>
 *
 * This class is used as a simple API endpoints holder.
 * <br> <br>
 * Wherever there is a "/" at the end of an endpoint, it indicates the need
 * for one or more parameters at the end of the request URL.
 */
public final class API
{
    public static final String URL = "http://192.168.1.8/physiolink/api/";

    /* Provision related API endpoints */
    public static final String CREATE_PROVISION = API.URL + "/provisions/create/";
    public static final String EDIT_PROVISION = API.URL + "/provisions/edit/";
    public static final String SHOW_PROVISIONS = API.URL + "/provisions/show";

    /* Doctor related API endpoints */
    public static final String CREATE_DOCTOR = API.URL + "/doctors/create/";
    public static final String EDIT_DOCTOR = API.URL + "/doctors/edit/";
    public static final String SHOW_DOCTOR = API.URL + "/doctors/show/";
    public static final String SHOW_DOCTORS = API.URL + "/doctors/show";

    /* Patient related API endpoints */
    public static final String CREATE_PATIENT = API.URL + "/patients/create/";
    public static final String EDIT_PATIENT = API.URL + "/patients/edit/";
    public static final String SHOW_PATIENTS = API.URL + "/patients/show/";
}
