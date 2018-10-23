package sql;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		//���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("134.175.219.242",6379);
        System.out.println("���ӳɹ�");
        //���� redis �ַ�������
        jedis.set("runoobkey", "www.runoob.com");
        // ��ȡ�洢�����ݲ����
        System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("runoobkey"));
        hashMapCmdTest(jedis);
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("string", "str");
        jedis.set("runoobkey", "www.runoob.com");
        
	}
	
	/**
     * redis��hash���ͳ��ò���
     * @param jedis
     */
    public static void hashMapCmdTest(Jedis jedis){

        System.out.println("----------------redis-HashMap-----------------");
        //hset:����ֵΪkeyΪ�·���1��Ϊ�ɸ��Ǿ�ֵ����0
        //System.out.println("hset:"+jedis.hset("user","name","wangshaoyi"));

        Map<String,String> map = new HashMap<String,String>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("stu", new Student("lihua",11,"W"));
        //System.out.println("hmset:" + jedis.hmset("user", map1));

        map.put("name","wsy");
        map.put("age","29");
        map.put("sex", "M");
        map.put("score", "90");
        //hmset:map����
        System.out.println("hmset:" + jedis.hmset("user", map));

        //hexists:�ж�hashmap��key�Ƿ����
        System.out.println("hexists:"+jedis.hexists("user","age"));

        //hget:��ȡmap��key��Ӧ��value
        System.out.println("hget:"+jedis.hget("user", "score"));

        //hgetAll:��ȡmap�����ж���
        System.out.println("hgetAll:"+jedis.hgetAll("user"));

        //hkeys:��ȡmap������key
        System.out.println("hkeys:"+jedis.hkeys("user"));

        //hvals:��ȡmap������value
        System.out.println("hvals:"+jedis.hvals("user"));


        //hmget:������ȡkeys�Ķ��󣬷���List
        //System.out.println("hmget:"+jedis.hmget("user","age","name"));

        //hlen:map�Ĵ�С
        //System.out.println("hlen:"+jedis.hlen("user"));

        //hdel:ɾ��map�ж�Ӧkey,��ȷɾ������1
        //System.out.println("hdel:"+jedis.hdel("user","age0"));

        //System.out.println("----------------redis-HashMap-----------------\n");

    }

	
}