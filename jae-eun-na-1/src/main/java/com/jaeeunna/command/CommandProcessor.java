package com.jaeeunna.command;

import com.jaeeunna.ui.Input;
import com.jaeeunna.ui.Output;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandProcessor {
    public void start(Input input, Output output) {

        // TODO: while 제거하기.
        // CommandProcessor 의 하는 일은 다음과 같다.
        // 1. CommandContextParser에게 CommandContext 생성 요청
        // 2. 알맞은 CommandHandler를 호출(CommandContext, BowlingState)
        // 3. handler 결과를 Ouput에게 전달
        // 인데, 하나의 커맨드 명령에 대해서 이렇게 해야한다.
        // 따라서 각 라인을 도는 while문은 외부로 빠져야한다.

        // 그런데 handler는 어디에서 생성되어야 하는가? Command enum 안에 박아놓으면 안되나?
        while (input.hasNextCommand()) {

            // TODO: CommandResolver 추가하기
            // 생각해보면, 추후에 추가할 CommandHandler가 원하는 입력은 Input이 아닐 것이다.
            // Handler는 단순히 Command의 종류와, 그 Command를 처리하는데 필요한 모든 부가정보만 (argument, options...등)
            // 입력으로 받고 싶어하기 때문이다. (이 정보를 CommandContext라 하겠다.)
            // 따라서, 선택지는 두 가지가 존재한다.
            // 1. Input 인터페이스의 구현체가 CommandContext 를 제공
            // 2. CommandResolver 같은 중간 계층을 두기
            // 2번이 적절해 보인다. 그 이유는
            // 1. Input 인터페이스는 콘솔 뿐 아니라 추후에 파일, 네트워크 등의 입력까지 염두에 둔 것이므로
            // 각 입력 소스별로 해야 할 일이 다를 것이다. (Closable, Async call in network...)
            // 심지어 네트워크에서 HTTP를 통한 json 등의 명령 입력을 제공한다면, 더욱 분리해야 함이 옳다.
            // 따라서 두 기능을 Input 구현체에 넣는 것은 SRP에 어긋나므로, 각 Command 별로 Context를 만드는 법을 아는
            // CommandResolver (더 좋은 이름을 지어야 한다.) 를 생성하는 방향이 더 나아 보인다. package는 command 안이 적절해보인다.
            // 이름 후보 : CommandContextResolver CommandContextProvider(유력), CommandContextParser(유력), CommandContextGenerator
            // 추가적으로 CommandContext 역시 만들어야한다. 인자가 3개면 되려나? command, option, arguments
            // arguments는 순서가 중요해보인다. 그러나 option역시 그러한가?

            final Command command = input.nextCommand();

            switch (command) {
                case INIT: {
                    output.println("----> Input player names, when you finished, input \"@DONE\"\n" +
                            "----> Now, Game Start.\n" +
                            "----> Frame 1.");

                    while (input.hasNextArgument()) {
                        String player = input.nextArgument();
                        if (player.equalsIgnoreCase("@DONE")) {
                            break;
                        }
                    }
                    break;
                }
                case SHOW: {
                    output.println("----> [ERROR] nothing to show");
                    break;
                }
                case UNKNOWN: {
                    output.println("----> [ERROR] unknown command");
                    break;
                }
                default: {
                    throw new RuntimeException("should not reach here");
                }
            }
        }
    }
}
