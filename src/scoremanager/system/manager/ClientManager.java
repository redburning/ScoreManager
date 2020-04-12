package scoremanager.system.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import scoremanager.system.vo.Client;

/**
 * 对在线用户的管理
 * @author redburning
 *
 */
public class ClientManager {

	private static ClientManager instance = new ClientManager();
	
	private ClientManager() {
		
	}
	
	public static ClientManager getInstance() {
		return instance;
	}
	
	private Map<String, Client> map = new HashMap<String, Client>();
	
	public void addClient(String sessionId, Client client) {
		map.put(sessionId, client);
	}
	
	public void removeClient(String sessionId) {
		map.remove(sessionId);
	}
	
	public Client getClient(String sessionId) {
		return map.get(sessionId);
	}
	
	public Collection<Client> getAllClient() {
		return map.values();
	}
	
}
