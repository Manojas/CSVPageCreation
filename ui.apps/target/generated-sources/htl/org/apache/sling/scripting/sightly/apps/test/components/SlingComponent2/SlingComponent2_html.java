/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.test.components.SlingComponent2;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class SlingComponent2_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_cd = null;
Collection var_collectionvar3_list_coerced$ = null;
out.write("<h2>Sling model example</h2>\n");
_global_cd = renderContext.call("use", com.mindtree.test.core.models.SlingModelImpl.class.getName(), obj());
out.write("<div></div>\n</ul>\n<ul>\n<li>");
{
    String var_0 = (("Page title is:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_cd, "pageTitle"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</li>\n<li>");
{
    String var_1 = (("HomePage is:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_cd, "homePage"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</li>\n<li>");
{
    String var_2 = (("Modified is:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_cd, "lastModified"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</li>\n</ul>\n");
{
    Object var_collectionvar3 = renderContext.getObjectModel().resolveProperty(_global_cd, "names");
    {
        long var_size4 = ((var_collectionvar3_list_coerced$ == null ? (var_collectionvar3_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar3)) : var_collectionvar3_list_coerced$).size());
        {
            boolean var_notempty5 = (var_size4 > 0);
            if (var_notempty5) {
                {
                    long var_end8 = var_size4;
                    {
                        boolean var_validstartstepend9 = (((0 < var_size4) && true) && (var_end8 > 0));
                        if (var_validstartstepend9) {
                            out.write("<ul>");
                            if (var_collectionvar3_list_coerced$ == null) {
                                var_collectionvar3_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar3);
                            }
                            long var_index10 = 0;
                            for (Object item : var_collectionvar3_list_coerced$) {
                                {
                                    boolean var_traversal12 = (((var_index10 >= 0) && (var_index10 <= var_end8)) && true);
                                    if (var_traversal12) {
                                        out.write("\n<li>");
                                        {
                                            String var_13 = ("Names are:" + renderContext.getObjectModel().toString(renderContext.call("xss", item, "text")));
                                            out.write(renderContext.getObjectModel().toString(var_13));
                                        }
                                        out.write("</li>\n\n\n<h3>");
                                        {
                                            String var_14 = ("Path Node:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_cd, "pathBrowser"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_14));
                                        }
                                        out.write("</h3>\n<h3>");
                                        {
                                            String var_15 = ("Nationality:" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_cd, "isIndian"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_15));
                                        }
                                        out.write("</h3>\n<h3>");
                                        {
                                            String var_16 = ("Gender: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_cd, "gender"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_16));
                                        }
                                        out.write("</h3>\n\n\n\n");
                                    }
                                }
                                var_index10++;
                            }
                            out.write("</ul>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar3_list_coerced$ = null;
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

