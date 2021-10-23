package ProjectCode.services;

import ProjectCode.Entities.Client;
import ProjectCode.models.ClientRequest;
import ProjectCode.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    private List<String> blacklistedTokens = new LinkedList<>();
    private List<String> tokens = new LinkedList<>();

    public boolean saveClient(ClientRequest clientRequest) {

        Client byUsername = clientRepository.findByUsername(clientRequest.getUsername());
        if(byUsername!=null)
            return false;

        Client client = new Client(clientRequest);
        clientRepository.save(client);
        return true;
    }

    public boolean editClient(ClientRequest clientRequest) {
        int id = clientRepository.findByUsername(clientRequest.getUsername()).getId();
        clientRepository.delete(clientRepository.findByUsername(clientRequest.getUsername()));
        Client client = new Client(clientRequest);
        client.setId(id);
        clientRepository.save(client);
        return true;
    }

    public boolean deleteClient(String username) {
        clientRepository.delete(clientRepository.findByUsername(username));
        return true;
    }

    public Client getClientByUsername(String username) {
        Client byUsername = clientRepository.findByUsername(username);
        return byUsername;
    }

    public List<String> getBlacklistedTokens() {
        return blacklistedTokens;
    }

    public boolean addBlacklistedToken(String token)
    {
        blacklistedTokens.add(token);
        return true;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public boolean addToken(String token)
    {
        tokens.add(token);
        return true;
    }
}
