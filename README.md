
## Not secured urls
http://localhost:8080/
## Restricted urls
http://localhost:8080/secretaryRoom  
http://localhost:8080/bossRoom

### REST API
http://localhost:8080/rest/secretaryRoom  
http://localhost:8080/rest/bossRoom
## Users and access
<table>
<tr><th>User</th><th>Password</th><th>Hall</th><th>Secretary Room</th><th>Boss Room</th></tr>
<tr><td>anonimous</td><td></td><td>X</td><td></td><td></td></tr>
<tr><td>Lesha</td><td>12345</td><td>X</td><td>X</td><td>X</td></tr>
<tr><td>Masha</td><td>12345</td><td>X</td><td>X</td><td></td></tr>
<tr><td>Dasha</td><td>12345</td><td>X</td><td></td><td>X</td></tr>
</table>

## REST access
to get token: http://localhost:8080/rest/auth?username={XXX}&password={YYY}  <small>(for example http://localhost:8080/rest/auth?username=Lesha&password=12345 )  </small>  
to get resource:  http://localhost:8080/rest/{resource}?token={token} <small>(for example http://localhost:8080/rest/bossRoom?token=EKOSBCKE3CXHA61Y ) </small>