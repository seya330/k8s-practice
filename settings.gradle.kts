rootProject.name = "k8s-practice"

include(
    "order:core",
    "order:application",
    "order:api",
    "order:adapter-persistence",
    "order:adapter-web",

    "product:core",
    "product:application",
    "product:api",
    "product:adapter-persistence",

    "cart"
)