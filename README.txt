
1. Register your website at https://www.google.com/recaptcha/admin
2. Registration process will generate site key and secret key which will be used for accessing the webservice.
# Site key = 6LfLS84ZAAAAAIL8otYOFgxnIkiYVuB_NRMzpvF5
#Secrey = 6LfLS84ZAAAAAAUNUoLtTocj4N_VoVkZhkol-Ls_

3. Add below mentioned script and div in your webpage for recaptch widget.

  <div class="g-recaptcha" data-sitekey="your_site_key"></div>

<script src='https://www.google.com/recaptcha/api.js'></script>

4. Refer CaptchaService.java for server side validation.


https://www.baeldung.com/spring-security-registration-captcha
https://github.com/Baeldung/spring-security-registration/tree/master/src/main/java/com/baeldung/captcha


https://www.youtube.com/watch?v=5wZWAqEwBj8&ab_channel=AlmightyJava












