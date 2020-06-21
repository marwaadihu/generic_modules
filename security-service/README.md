# Security - Service
Follow below steps to use this service in your project.
1. Add dependency of this project using maven | gradle in your project.
2. If default token generation method not works for the use case, extend JwtTokenUtil class and override the necessary methods.
3. Create Bean of JwtTokenUtil (or your extended class if any)
4. Create Bean of AllowPatternRequest
5. Implement UserDetails class.
6. Create Bean of UserDetails.
7. If default util method not works for the use case, extend SecurityUtil class and override the necessary methods.
