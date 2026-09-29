package com.github.milomarten.taisha_rangers2.bot;

import com.github.milomarten.taisha_rangers2.command.localization.LocalizedCommandSpec;
import com.github.milomarten.taisha_rangers2.command.parameters.NoParameterParser;
import com.github.milomarten.taisha_rangers2.command.response.CommandResponse;
import com.github.milomarten.taisha_rangers2.pokemon.TokenTableService;
import org.springframework.stereotype.Component;

@Component("tokens")
public class TokenCommand extends LocalizedCommandSpec<Void> {
    private final TokenTableService tokenTableService;

    public TokenCommand(TokenTableService tokenTableService) {
        super("tokens");
        this.tokenTableService = tokenTableService;

        this.setParameterParser(NoParameterParser.create());
    }

    @Override
    protected CommandResponse doAction(Void params) {
        var tokens = String.join(", ", tokenTableService.getTokens());

        return localizationFactory.createResponse("command.tokens.response", tokens);
    }
}
