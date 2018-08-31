package pep.pesoftware.fwf.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import pep.pesoftware.coc.jwt.JWTUserInfo;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

public class JwtTokenUtil {

    /**
     * RS256通过私钥获取Token
     * @param jwtUserInfo
     *          用户信息
     * @return
     *          token字符串
     * @throws Exception
     */
//    public String generateToken(JWTUserInfo jwtUserInfo) throws Exception {
//        String compactJws = Jwts.builder()
//                .setSubject(jwtUserInfo.getUserId())
//                .claim("userName", jwtUserInfo.getUsername())
//                .claim("name", jwtUserInfo.getName())
//                .claim("role", jwtUserInfo.getRole())
//                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
//                .signWith(SignatureAlgorithm.RS256, getPrivateKey(priKeyPath))
//                .compact();
//        return compactJws;
//    }

    /**
     * HS256算法生成Token
     * @param jwtUserInfo
     *          用户信息
     * @return
     *          生成的Token
     */
    public static String generateToken(JWTUserInfo jwtUserInfo,int expire,String tokenSecret){
        if(jwtUserInfo == null){
            return null;
        }
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenSecret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .setSubject(jwtUserInfo.getUserId())
                .claim("userName", jwtUserInfo.getUserName())
                .claim("realName", jwtUserInfo.getRealName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }

    /**
     * RS256通过公钥解密Token
     * @param token
     *          token字符串
     * @return
     *          返回用户信息
     * @throws Exception
     */
//    public JWTUserInfo getInfoFromToken(String token) throws Exception {
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getPublicKey(pubKeyPath)).parseClaimsJws(token);
//        Claims body = claimsJws.getBody();
//        return new JWTUserInfo(body.getSubject(),
//                getObjectValue(body.get("userName")),
//                getObjectValue(body.get("name")),
//                getObjectValue(body.get("role")));
//    }

    /**
     * HS256解密Token
     * @param token
     *          token字符串
     * @return
     *          返回用户信息
     */
    public static JWTUserInfo getInfoFromToken(String token, String tokenSecret){
        if(token == null){
            return null;
        }
        Claims body = null;
        try {
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenSecret);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
            body = claimsJws.getBody();
        }catch (Exception e){
            return null;
        }
        return new JWTUserInfo(body.getSubject(),
                getObjectValue(body.get("userName")),
                getObjectValue(body.get("realName")));
    }

    private static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }

//    /**
//     * 获取公钥
//     * @param filename
//     *          文件名称
//     * @return
//     *         公钥信息
//     * @throws Exception
//     */
//    private PublicKey getPublicKey(String filename) throws Exception {
//        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
//        DataInputStream dis = new DataInputStream(resourceAsStream);
//        byte[] keyBytes = new byte[resourceAsStream.available()];
//        dis.readFully(keyBytes);
//        dis.close();
//        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory kf = KeyFactory.getInstance("RSA");
//        return kf.generatePublic(spec);
//    }
//
//    /**
//     * 获取密钥
//     * @param filename
//     *          文件名称
//     * @return
//     *          私钥信息
//     * @throws Exception
//     */
//    private PrivateKey getPrivateKey(String filename) throws Exception {
//        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
//        DataInputStream dis = new DataInputStream(resourceAsStream);
//        byte[] keyBytes = new byte[resourceAsStream.available()];
//        dis.readFully(keyBytes);
//        dis.close();
//        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory kf = KeyFactory.getInstance("RSA");
//        return kf.generatePrivate(spec);
//    }
//
//    /**
//     * 生存rsa公钥和密钥
//     * @param publicKeyFilename
//     *          公钥文件名
//     * @param privateKeyFilename
//     *          私钥文件名
//     * @param password
//     *          密码
//     * @throws IOException
//     * @throws NoSuchAlgorithmException
//     */
//    private void generateKey(String publicKeyFilename,String privateKeyFilename,String password) throws IOException, NoSuchAlgorithmException {
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        SecureRandom secureRandom = new SecureRandom(password.getBytes());
//        keyPairGenerator.initialize(1024, secureRandom);
//        KeyPair keyPair = keyPairGenerator.genKeyPair();
//        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
//        FileOutputStream fos = new FileOutputStream(publicKeyFilename);
//        fos.write(publicKeyBytes);
//        fos.close();
//        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
//        fos = new FileOutputStream(privateKeyFilename);
//        fos.write(privateKeyBytes);
//        fos.close();
//    }

}