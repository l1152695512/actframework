package act.cli.meta;

/*-
 * #%L
 * ACT Framework
 * %%
 * Copyright (C) 2014 - 2017 ActFramework
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import act.asm.Type;
import act.util.AsmTypes;
import act.util.DestroyableBase;
import org.osgl.$;

/**
 * Stores Command parameter meta info
 */
public class CommandParamMetaInfo extends DestroyableBase {
    private String name;
    private Type type;
    private boolean readFileContent;
    private Type componentType;
    private boolean context;
    @Deprecated
    private String cliSessionAttributeKey;
    private ParamOptionAnnoInfo optionInfo;

    public CommandParamMetaInfo name(String name) {
        this.name = $.NPE(name);
        return this;
    }

    public String name() {
        return name;
    }

    public CommandParamMetaInfo type(Type type) {
        this.type = $.NPE(type);
        if (AsmTypes.isContextType(type)) {
            context = true;
        }
        return this;
    }

    public Type type() {
        return type;
    }

    public CommandParamMetaInfo setContext() {
        this.context = true;
        return this;
    }

    public boolean isContext() {
        return context;
    }


    public CommandParamMetaInfo componentType(Type type) {
        this.componentType = $.NPE(type);
        return this;
    }

    public Type componentType() {
        return componentType;
    }

    public CommandParamMetaInfo optionInfo(ParamOptionAnnoInfo optionInfo) {
        this.optionInfo = $.NPE(optionInfo);
        optionInfo.paramName(name);
        return this;
    }

    public ParamOptionAnnoInfo optionInfo() {
        return optionInfo;
    }

    public void setReadFileContent() {
        readFileContent = true;
    }

    public boolean readFileContent() {
        return readFileContent;
    }

}
