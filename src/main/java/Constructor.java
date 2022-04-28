import java.util.Objects;

public class Constructor {

    private String constructorId;
    private String url;
    private String name;
    private String nationality;

    public Constructor() {
    }

    public Constructor(String constructorId, String url, String name, String nationality) {
        this.constructorId = constructorId;
        this.url = url;
        this.name = name;
        this.nationality = nationality;
    }

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Constructor)) return false;
        Constructor that = (Constructor) o;
        return Objects.equals(getConstructorId(), that.getConstructorId()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getNationality(), that.getNationality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConstructorId(), getUrl(), getName(), getNationality());
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "constructorId='" + constructorId + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
