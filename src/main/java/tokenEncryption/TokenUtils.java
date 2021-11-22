package tokenEncryption;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.*;

public class TokenUtils {

    private static String createJwtJwsHMAC(String clientId, String key) {

        byte[] decodedKey = Base64.getDecoder().decode(key);

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("client-id", clientId);
        claims.put("iat",new Date());

        String token = Jwts .builder()
                .setIssuedAt(new Date())
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, decodedKey)
                .compact();
        return token;
    }


    public static String createJwt256Token(String secretkey) throws Exception{
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS512");
//        header.put("typ", "JWT");
        JWTCreator.Builder builder = JWT.create();
        builder.withHeader(header);

        Map<String, String> claims=new HashMap<>();
        claims.put("client-id", "kggupta");
        for (Map.Entry<String, String> entry : claims.entrySet()) {
            builder.withClaim(entry.getKey(), entry.getValue());
        }
        builder.withClaim("iat", new Date());
        String token = builder.sign(Algorithm.HMAC256(secretkey));
        return token;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(createJwtJwsHMAC("kggupta","abcdefghijklmn"));
        System.out.println(createJwt256Token("abcdefghijklmn"));

    }

}
