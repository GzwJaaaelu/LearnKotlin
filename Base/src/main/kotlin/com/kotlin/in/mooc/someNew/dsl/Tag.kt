package com.kotlin.`in`.mooc.someNew.dsl

open class Tag(val name: String): Node {
    //  子节点
    val children = ArrayList<Node>()

    //  属性
    val proerties = HashMap<String, String>()

    operator fun String.invoke(value: String) {
        proerties[this] = value
    }

    operator fun String.invoke(block: Tag.() -> Unit) {
        children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus() {
        children.add(StringNode(this))
    }

    override fun render(): String {
        return StringBuilder()
                .append("<")
                .append(name)
                .let {
                    stringBuilder ->
                    if (this.proerties.isNotEmpty()) {
                        this.proerties.forEach {
                            stringBuilder.append(" ")
                                    .append(it.key)
                                    .append("=\"")
                                    .append(it.value)
                                    .append("\"")
                        }
                    }
                    stringBuilder
                }
                .append(">")
                .let {
                    stringBuilder ->
                    children.map(Node::render).map(stringBuilder::append)
                    stringBuilder
                }
                .append("</$name>")
                .toString()
    }
}